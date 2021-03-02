import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const ProductAddService = x => {

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $(`#prd-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/prd/list`
    })

    $.ajax({
        url: `${x}/products`,
        type: `POST`,
        data: JSON.stringify({
            prdName: $(`#prdName`).val(),
            price: $(`#price`).val(),
            inventory: $(`#inventory`).val() 
        }),
        dataType: `json`,
        contentType: `application/json`,
        success: d => {
            if(d.message === `SUCCESS`) {
                location.href=`${x}/move/prd/list`
                alert(`등록 완료`)
            }
        },
        error: e => { alert(`제품 등록 실패: ${e}`)	}
    })
}

export const ProductAddPage = () => {
    return (<>
<h1>제품 등록하기</h1>
<form>
	<table style="width:80%; padding: 10px;">
	  <tbody>
		  <tr>
		    <th style="width:30%;">항목</th>
		    <th>내용</th>
		  </tr>
		  <tr>
		    <td>제품명</td>
		    <td><input id="prdName" type="text" name="prdName" class="form-control" 
		    		   placeholder="제품명 입력" style="width:95%; height:100%; font-size:medium;" required/></td>
		  </tr>
		  <tr>
		    <td>판매가</td>
		    <td><input id="price" type="text" name="price" class="form-control"
		    		   placeholder="판매가 입력" style="width:95%; height:100%; font-size:medium;" required/></td>
		  </tr>
		  <tr>
		    <td>재고수량</td>
		    <td><input id="inventory" type="text" name="inventory" class="form-control"
		    		   placeholder="재고수량 입력" style="width:95%; height:100%; font-size:medium;"/></td>
		  </tr>
	  </tbody>
	</table>
	<div style="text-align: center; padding-top: 30px;">			
		<button id="done-btn">등록하기</button>
		<button type="reset">다시 작성</button>
		<button id="prd-btn">뒤로가기</button>
		<button id="home-btn">HOME</button>
	</div>
</form>
        </>)
    }