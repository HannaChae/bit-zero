import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const BoardListService = x => {
    
    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $.getJSON(`${x}/boards/list`, d => {
        $.each(d, (i, j) => {
            $(`<tr></td>
                <td>${j.boardNum}</td>
                <td><a class="title" href="#" id="${j.boardNum}">${j.title}</a></td>
                <td>${j.writtenDate}</td>
                
                </tr>`)
                .css({padding: `20px`, textAlign: `center`})
                .appendTo(`#tab`)
        })
        $(`.title`).each(function(){
            $(this).click(e => {
                e.preventDefault()
                localStorage.setItem(`title`, `${this.id}`)
                location.href=`${x}/move/brd/det`
            
            })
        })
    })
}

export const BoardListPage = () => {
    return (<>
    <h1>게시글 목록</h1>
    <table id="tab" >
        <tr>
            <th style="width: 10%">글번호</th>
            <th style="width: 65%">제목</th>
            <th>등록일시</th>
        </tr>
    </table>
    <div style="text-align: center; padding-top: 30px;">
        <button id="wri">글쓰기</button>
        <button id="home-btn">HOME</button>
    </div>
        </>)
    }