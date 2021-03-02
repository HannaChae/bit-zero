import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const MemberLoginService = x => {
    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $(`#login-btn`).click( e => {
    e.preventDefault()
        $.ajax({
            url:`${x}/members/login`,
            type: 'POST',
            data: JSON.stringify({
                memid: $('#memid').val(),
                password: $('#password').val(),
                name: $(`#name`).val(),
            }),
            dataType: 'json',
            contentType: 'application/json',
            success: data => {
                if(data.message === 'SUCCESS'){
                    sessionStorage.setItem('memid', data.sessionMember.memid)
                    sessionStorage.setItem('password', data.sessionMember.password)
                    sessionStorage.setItem('name', data.sessionMember.name)
                    location.href=`${x}/move/mem/myPage`
                }else{
                    alert(`로그인 실패`)
                    location.reload();
                }
            },
            error: error => {
                alert(`Fail`)
                console.log(`로그인 실패 `)
            }
        })
    })
}

export const MemberLoginPage = () => {

    return (<>
    <form>
        <h1>로그인</h1>
        <button type="button" class="button" id="home-btn">Home</button>
        <label for="memid"><b>ID</b></label>
        <input type="text" placeholder="Enter ID" id="memid" required/>
        <label for="password"><b>PW</b></label>
        <input type="password" placeholder="Enter pw" id="password" required/>
        <button type="button" class="button" id="login-btn">로그인</button>
    </form>
        </>)
}