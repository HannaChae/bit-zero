import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const MemberJoinService = x => {

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })
    $(`#join-btn`).click( e => {
        e.preventDefault()
        $.ajax({
            url:`${x}/members/join`,
            type: 'POST',
            data: JSON.stringify({
                memid: $('#memid').val(),
                password: $('#password').val(),
                name: $('#name').val()
            }),
            dataType: 'json',
            contentType: 'application/json',
            success: data => {
                location.href=`${x}/move/mem/login`
            },
            error: error => {
                alert(`Fail`)
                console.log(`회원가입 실패`)
            }
        })
    })
}

export const MemberJoinPage = () => {
    return (<>
    <form>
        <h1>회원가입</h1>
        <button type="button" class="button" id="home-btn">Home</button>
        <label for="memid"><b>ID</b></label>
        <input type="text" placeholder="Enter ID" id="memid" required/>
        <label for="password"><b>PW</b></label>
        <input type="password" placeholder="Enter pw" id="password" required/>
        <label for="name"><b>NAME</b></label>
        <input type="text" placeholder="Enter name" id="name" required/>
        <button type="button" class="button" id="join-btn">완료</button>
    </form>
        </>)
    }