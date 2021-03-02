import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const BoardWriteService = x => {
    $(`#back-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/brd/board`
    })

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $(`#writ`).click(e => {
        e.preventDefault()
        $.ajax({
        url: `${x}/boards/writer`,
        type: 'POST',
        data: JSON.stringify({
             title: $('#title').val(),
             content: $('#content').val()
            }),
        dataType:'json',
        contentType:'application/json',
        success: d =>{
            if(d.message === 'SUCCESS'){
                alert(`글쓰기 성공`)
                 location.href =`${x}/move/brd/board`
            }else{
                alert('글쓰기 실패')
            }},
             error: e => {
                   alert('글쓰기 에러')
            }
        })
    })
}

export const BoardWritePage = () => {
    return (<>
<h1>게시글 작성</h1>
<form>
	<table id="tab" >
		<tr>
			<th style="width: 20%">제목</th>
			<td style="width: 80%"><input type="text" id ="title" placeholder="글 제목 입력" style="width:98%; height:100%;"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="15" cols="65" id="content" placeholder="글 내용 입력" style="width:98%;"></textarea></td>
		</tr>
	</table>
</form>
<div style="text-align: center; padding-top: 30px;">			
	<button id="writ">등록하기</button>
	<button id="back-btn">뒤로가기</button>
	<button id="home-btn">HOME</button>
</div>
        </>)
    }