import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const MemberMyService = x => {

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })
    
    $(`#modify-btn`).click( e => {
    e.preventDefault()
        $.ajax({
            url:`${x}/members/modify`,
            type:`PUT`,
            data: JSON.stringify({
                memid: sessionStorage.getItem('memid'),
                password: $('#password').val()
            }),
            dataType:`json`,
            contentType:`application/json`,
            success: data => {
                if(data.message === 'SUCCESS'){
                    alert('비밀번호 수정 완료')
                        location.reload();
                        sessionStorage.setItem('password', data.sessionMember.password)
                }else{
                    alert('비밀번호 수정 실패')
                        location.reload();
                }
            },
            error: error => {
                alert(`Fail`)
                console.log(`비밀번호 수정 실패 `)
            }
        })
    })
    $(`#withdrawal-btn`).click( e => {
    e.preventDefault()
        $.ajax({
            url:`${x}/members/withdrawal`,
            type:`DELETE`,
            data: JSON.stringify({
                memid: sessionStorage.getItem('memid')
            }),
            dataType:`json`,
            contentType:`application/json`,
            success: data => {
                if(data.message === 'SUCCESS'){
                    alert('회원탈퇴 완료')
                        location.href = `${x}/./`
                        sessionStorage.clear()
                }else{
                    alert('회원탈퇴 실패')
                        location.reload();
                }
            },
            error: error => {
            alert(`Fail`)
            console.log(`회원탈퇴 실패 `)
            }
        })
    })
    $(`#logout-btn`).click( e => {
        e.preventDefault()
        sessionStorage.clear()
        location.href = `${x}/./`
    })
}

export const MemberMyPage = () => {
    return (<>
       <form>
            <h1>마이페이지</h1>
            <button type="button" class="button" id="home-btn">Home</button>
            <button type="button" class="button" id="logout-btn">로그아웃</button>
            <label for="password"><b>NEW PW</b></label>
            <input type="password" placeholder="Enter new pw" id="password" required/>
            <button type="button" class="button" id="modify-btn">비밀번호 수정</button>
            <button type="button" class="button" id="withdrawal-btn">회원 탈퇴</button>
        </form>
        </>)
    }