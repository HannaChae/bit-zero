import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const ProductListService = x => {

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $(`#add-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/prd/add`
    })

    $.getJSON(`${x}/products/list`, d => {
        $.each(d, (i, j) => {
            $(`<tr><td>${j.prdId}</td>
                <td><a class="title" href="#" id="${j.prdId}">${j.prdName}</a></td>
                <td>${j.price}</td>
                <td>${j.inventory}</td></tr>`)
                .css({padding: `15px`, textAlign: `center`, fontSize: `small`})
                .appendTo(`#tab`)
        })
            
        $(`.title`).each(function(){
            $(this).click(e => {
                e.preventDefault()
                localStorage.setItem(`prdId`, `${this.id}`)
                location.href=`${x}/move/prd/detail`
            })
        })
    })
}

export const ProductListPage = () => {
    return (<>
    <h1>제품 목록보기</h1>
		<div id="prd-table">
			<table id="tab">
				<tr>
					<th>제품번호</th>
					<th>제품명</th>
					<th>가격</th>
					<th>재고수량</th>
				</tr>
			</table>
		</div>
<div style="text-align: center; margin-top:30px;">
	<button class="button" id="add-btn">제품추가</button>
	<button class="button" id="home-btn">HOME</button>
</div>
        </>)
    }