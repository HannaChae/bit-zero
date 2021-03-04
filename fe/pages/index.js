import React, { useEffect, useState } from 'react';
import axios from "axios";
import { LayoutNine } from "../components/Layout";
import { BlogPostSlider } from "../components/Blog";
import { SectionTitleOne } from "../components/SectionTitle";
import { HeroSliderSeven } from "../components/HeroSlider";
import { CategoryGridThree } from "../components/Category";
import { CountdownTimerOne } from "../components/Countdown";

import blogData from "../data/blog-posts/blog-post-one.json";
import heroSliderData from "../data/hero-sliders/hero-slider-seven.json";

const Collection = () =>{
  
  const [board, setBoard] = useState([])
  const URL = '/board/all'
  useEffect(()=>{
    axios.get(URL, )
    .then((response) => {
      alert('restful success')
      setBoard(response.data)
    })
    .catch((error) => {
      alert('실패')
      throw error;
    })
    
  },[])

return (
  <>
  <ul>
    {board.map(i => (
      <il
        key = {i.brdNo}
        >
          {i.brdWrtDate}
      </il>
    ))}
  </ul>
    <LayoutNine aboutOverlay={false}>
      {/* hero slider */}
      <HeroSliderSeven sliderData={heroSliderData} />
      <div className="space-mb--r100"></div>
    </LayoutNine>
  </>);
};


export default Collection;