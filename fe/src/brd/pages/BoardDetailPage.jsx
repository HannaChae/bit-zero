import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const BoardDetailService = x => {
    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $(`#wri`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/brd/writer`
    })

    $(`#wri-list`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/brd/writerList`
    })
    $(`#myPage-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/mem/myPage`
    })
}

export const BoardDetailPage = () => {
    return (<>
        <h1>게시판</h1>
            <button class="button" id="home-btn">Home</button>
            <button class="button" id="myPage-btn">Back</button>
            <button class="button" id="wri">글쓰기</button>
            <button class="button" id="wri-list">글 목록</button>
        </>)
    }