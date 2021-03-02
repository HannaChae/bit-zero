import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import axios from 'axios'
import { debounce } from 'throttle-debounce'
import { useHistory, Link } from 'react-router-dom';

const DetService = x => {
    
    $(`#back-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/move/brd/board`
    })

    $(`#home-btn`).click(e => {
        e.preventDefault()
        location.href=`${x}/`
    })

    $.getJSON(`${x}/boards/${localStorage.getItem(`title`)}`, d => {
        $(`#boardNum`).text(d.boardNum)
        $(`#writtenDate`).text(d.writtenDate)
        $(`#boardTitle`).text(d.title)
        $(`#boardContent`).text(d.content)
        
         $('#update').click(e => { 
         $('#boardTitle').html('<input type ="text" id="update-title" value="'+d.title+'"/>')
         $('#boardContent').html('<textarea id="update-content" style="height: 300px"> "'+d.content+'"</textarea>')
         $(`#update`).html('<div id="confirm">수정완료</div>')
            $(`#confirm`).click(e => {
                e.preventDefault()
                $.ajax({
                    url: `${x}/boards/update`,
                    type: `PUT`,
                    data: JSON.stringify({
                        boardNum: d.boardNum,
                        title: $(`#update-title`).val(),
                        content: $(`#update-content`).val(),
                    }),
                    dataType: `json`,
                    contentType: `application/json`,
                    success: d => {
                        if(d.message === 'SUCCESS') {
                            alert(`수정 성공`)
                            location.href=`${x}/move/brd/writerList`
                        }else {
                            alert(`수정 실패`)
                        }
                    },
                    error: e => { alert(`수정 에러`)}
                })
                })
         
    })

        $(`#delete`).click(e => {
            e.preventDefault()
            $.ajax({
                url: `${x}/boards/remove`,
                type: `DELETE`,
                data: JSON.stringify({
                    boardNum: d.boardNum
                }),
                dataType: `json`,
                contentType: `application/json`,
                success: d => {
                    if(d.message === `SUCCESS`) {
                        alert(`삭제완료`)
                        location.href=`${x}/move/brd/writerList`
                    }else {
                        alert(`삭제 실패`)
                    }
                },
                error: e => { alert(`삭제 에러`)}
            })
        })
    })

}

export const DetPage = () => {
    return (<>
           <h1> 글 내용 </h1>
     <tr><th style="width: 10%" >글번호: <span id="boardNum"></span></th></tr>
    <tr><th style="width: 10%" >작성시간: <span id="writtenDate"></span></th></tr>      
    <tr><th style="width: 10%" class="text-center">제목: <span id="boardTitle"></span></th></tr>
     <table class="tab">
        <thead>
             <tr><td colspan="4" style="width: 50%"/>
             		내용:
                  <div id="boardContent" style="height: 300px">
                      
                  </div>
                
            </tr>
        </thead>

    </table>
	<button class="button" id="home-btn">Home</button>
	<button class="button" id="back">Back</button>
	<button class="button" id="update">수정하기</button>
	<button class="button" id="delete">삭제하기</button>
        </>)
    }