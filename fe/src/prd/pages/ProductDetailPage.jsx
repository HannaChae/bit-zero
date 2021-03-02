import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const ProductDetailService = x => {
    $(`#back-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/prd/list`
    })
    $.getJSON(`${x}/products/${localStorage.getItem(`prdId`)}`, d => {
        $(`#pId`).text(d.prdId)
        $(`#pName`).text(d.prdName)
        $(`#pPrice`).text(d.price)
        $(`#pInventory`).text(d.inventory)
        $(`#update-btn`).click(e => {
            $(`#pName`).html('<input id="update-prdName" type="text" value="'+ d.prdName +'"/>')
            $(`#pPrice`).html('<input id="update-price" type="text" value="'+ d.price +'"/>')
            $(`#pInventory`).html('<input id="update-inventory" type="text" value="'+ d.inventory +'"/>')
            $(`#update-btn`).html('<div id="confirm-btn">수정완료</div>')
            $(`#confirm-btn`).click(e => {
                e.preventDefault()
                $.ajax({
                    url: `${x}/products`,
                    type: `PUT`,
                    data: JSON.stringify({
                        prdId: d.prdId,
                        prdName: $(`#update-prdName`).val(),
                        price: $(`#update-price`).val(),
                        inventory: $(`#update-inventory`).val() 
                    }),
                    dataType: `json`,
                    contentType: `application/json`,
                    success: data => {
                        if(data.message === `SUCCESS`) {
                            alert(`수정 완료 !`)
                            location.href=`${x}/move/prd/detail`
                        }else {
                            alert(`수정 실패 !`)
                        }
                    },
                    error: error => { alert(`에러 발생 ! ${error}`)}
                })
            })
        })
        
        $(`#delete-btn`).click(e => {
            e.preventDefault()
            $.ajax({
                url: `${x}/products`,
                type: `DELETE`,
                data: JSON.stringify({
                    prdId: d.prdId
                }),
                dataType: `json`,
                contentType: `application/json`,
                success: data => {
                    if(data.message === `SUCCESS`) {
                        alert(`삭제 완료 !`)
                        location.href=`${x}/move/prd/list`
                    }else {
                        alert(`삭제 실패 !`)
                    }
                },
                error: error => { alert(`에러 발생 ! ${e}`)}
            })
        })
    })
}

export const ProductDetailPage = () => {
    return (<>
        <h1>제품 상세보기</h1>
    <table style="width:80%">
    <thead>
        <tr>
          <th style="width:20%">제품번호</th>
          <th style="width:35%">제품명</th> 
          <th style="width:25%">판매가</th>
          <th style="width:20%">재고수량</th>
        </tr>
    </thead>
    <tbody>
        <tr style="width: 100%; height: 40px;">
            <td><span id="pId"></span></td>
            <td><span id="pName"></span></td>
            <td><span id="pPrice"></span></td>
            <td><span id="pInventory"></span></td>
        </tr>
    </tbody>
  </table>
  <div style="text-align: center; padding-top: 30px;">
      <button class="button" id="back-btn">목록보기</button>
      <button class="button" id="home-btn">HOME</button>
      <button class="button" id="update-btn">수정하기</button>
      <button class="button" id="delete-btn">삭제하기</button>
  </div>
        </>)
    }