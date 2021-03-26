import PropTypes from "prop-types";
import React, { useState, Fragment } from "react";
import { Link } from "react-router-dom";
import MetaTags from "react-meta-tags";
import { connect } from "react-redux";
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic";
import { getDiscountPrice } from "../../helpers/product";
import LayoutOne from "../../layouts/LayoutOne";
import Breadcrumb from "../../wrappers/breadcrumb/Breadcrumb";
import axios from 'axios'
import { TextField } from '@material-ui/core';
import DaumPostcode from 'react-daum-postcode';
import Modal from '../../components/modals/AddrModal';
import $ from "jquery";
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;


const Checkout = ({ location, cartItems, currency }) => {
  
  const [ modalOpen, setModalOpen ] = useState(false);
  const openModal = () => {
      setModalOpen(true);
  }
  const closeModal = () => {
      setModalOpen(false);
  }


  const { pathname } = location;
  let cartTotalPrice = 0;
  const { IMP } = window;
  const [rcvName, setRcvName] = useState('')
  const [rcvPhone, setRcvPhone] = useState('')
  const [rcvAddr, setRcvAddr] = useState('')


    
  const placeOrder = e => {
    e.preventDefault()
    IMP.init('imp55713696');
    IMP.request_pay({
      pg : 'kakaopay',
      pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
      merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
      name : `테스트`,
      amount : 1,
      buyer_email : `a@test.com`,
      buyer_name : `${rcvName}`,
      buyer_tel : `${rcvPhone}`,
      buyer_addr : `${rcvAddr}`
    }, function(rsp) {
        if ( rsp.success ) {
          //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
          jQuery.ajax({
          url: "/", //cross-domain error가 발생하지 않도록 주의해주세요
          type: 'POST',
          dataType: 'json',
          data: {
          imp_uid : rsp.imp_uid
          //기타 필요한 데이터가 있으면 추가 전달
          }
        }).done(function(data) {
          //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
          if (data.success) {
          var msg = '결제가 완료되었습니다.';
          msg += '\n고유ID : ' + rsp.imp_uid;
          msg += '\n상점 거래ID : ' + rsp.merchant_uid;
          msg += '\결제 금액 : ' + rsp.paid_amount;
          msg += '카드 승인번호 : ' + rsp.apply_num;
          alert(msg);
        } else {
          //[3] 아직 제대로 결제가 되지 않았습니다.
          //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
          }
        });
      location.href='/my-account'+msg;
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
        location.href='/checkout';
        alert(msg);
        }
      });

    axios.post("http://localhost:8080/receiver/save",{
      rcvName, rcvPhone, rcvAddr
    })
      .then(response => {
      alert('주문 성공')
      })
      .catch(error =>{
      alert('주문 실패')
      })
    }

  return (
    <Fragment>
      <MetaTags>
        <title>Flone | Checkout</title>
        <meta
          name="description"
          content="Checkout page of flone react minimalist eCommerce template."
        />
      </MetaTags>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>
        Checkout
      </BreadcrumbsItem>
      <LayoutOne headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />
        <div className="checkout-area pt-95 pb-100">
          <div className="container">
            {cartItems && cartItems.length >= 1 ? (
              <div className="row">
                <div className="col-lg-7">
                  <div className="billing-info-wrap">
                    <h3>Billing Details</h3>
                    <div className="row">
                      <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                          <label>Name</label>
                          <TextField name="rcvName" required
                          onChange = { e => { setRcvName(`${e.target.value}`)}}
                          />
                        </div>
                      </div>
                      <div className="col-lg-12">
                        <div className="billing-info mb-20">
                          <label>Address</label>
                          <React.Fragment>
                            <button onClick={ openModal }>주소검색</button>
                            <Modal open={ modalOpen } close={ closeModal } header="주소 검색" type="submit">
                            </Modal>
                          </React.Fragment>
                          <TextField name="rcvAddr" required
                          onChange = { e => { setRcvAddr(`${e.target.value}`)}}
                          />
                        </div>
                      </div>
                      <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                          <label>Phone</label>
                          <TextField name="rcvPhone" required
                          onChange = { e => { setRcvPhone(`${e.target.value}`)}}
                          />
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div className="col-lg-5">
                  <div className="your-order-area">
                    <h3>Your order</h3>
                    <div className="your-order-wrap gray-bg-4">
                      <div className="your-order-product-info">
                        <div className="your-order-top">
                          <ul>
                            <li>Product</li>
                            <li>Total</li>
                          </ul>
                        </div>
                        <div className="your-order-middle">
                          <ul>
                            {cartItems.map((cartItem, key) => {
                              const discountedPrice = getDiscountPrice(
                                cartItem.price,
                                cartItem.discount
                              );
                              const finalProductPrice = (
                                cartItem.price * currency.currencyRate
                              ).toFixed(2);
                              const finalDiscountedPrice = (
                                discountedPrice * currency.currencyRate
                              ).toFixed(2);

                              discountedPrice != null
                                ? (cartTotalPrice +=
                                    finalDiscountedPrice * cartItem.quantity)
                                : (cartTotalPrice +=
                                    finalProductPrice * cartItem.quantity);
                              return (
                                <li key={key}>
                                  <span className="order-middle-left">
                                    {cartItem.name} X {cartItem.quantity}
                                  </span>{" "}
                                  <span className="order-price">
                                    {discountedPrice !== null
                                      ? currency.currencySymbol +
                                        (
                                          finalDiscountedPrice *
                                          cartItem.quantity
                                        ).toFixed(2)
                                      : currency.currencySymbol +
                                        (
                                          finalProductPrice * cartItem.quantity
                                        ).toFixed(2)}
                                  </span>
                                </li>
                              );
                            })}
                          </ul>
                        </div>
                        <div className="your-order-bottom">
                          <ul>
                            <li className="your-order-shipping">Shipping</li>
                            <li>Free shipping</li>
                          </ul>
                        </div>
                        <div className="your-order-total">
                          <ul>
                            <li className="order-total">Total</li>
                            <li>
                              {currency.currencySymbol +
                                cartTotalPrice.toFixed(2)}
                            </li>
                          </ul>
                        </div>
                      </div>
                      <div className="payment-method"></div>
                    </div>
                    <div className="place-order mt-25">
                    <button className="btn-hover" type="submit" onClick= {placeOrder}>Place Order</button>
                    </div>
                  </div>
                </div>
              </div>
            ) : (
              <div className="row">
                <div className="col-lg-12">
                  <div className="item-empty-area text-center">
                    <div className="item-empty-area__icon mb-30">
                      <i className="pe-7s-cash"></i>
                    </div>
                    <div className="item-empty-area__text">
                      No items found in cart to checkout <br />{" "}
                      <Link to={process.env.PUBLIC_URL + "/shop-grid-standard"}>
                        Shop Now
                      </Link>
                    </div>
                  </div>
                </div>
              </div>
            )}
          </div>
        </div>
      </LayoutOne>
    </Fragment>
  );
};

Checkout.propTypes = {
  cartItems: PropTypes.array,
  currency: PropTypes.object,
  location: PropTypes.object
};

const mapStateToProps = state => {
  return {
    cartItems: state.cartData,
    currency: state.currencyData
  };
};

export default connect(mapStateToProps)(Checkout);
