import { LayoutNine } from "../components/Layout";
import { BlogPostSlider } from "../components/Blog";
import { SectionTitleOne } from "../components/SectionTitle";
import { HeroSliderSeven } from "../components/HeroSlider";
import { CategoryGridThree } from "../components/Category";
import { CountdownTimerOne } from "../components/Countdown";

import blogData from "../data/blog-posts/blog-post-one.json";
import heroSliderData from "../data/hero-sliders/hero-slider-seven.json";

const Collection = () =>{
  return (
    <LayoutNine aboutOverlay={false}>
      {/* hero slider */}
      <HeroSliderSeven sliderData={heroSliderData} />
      <div className="space-mb--r100"></div>
    </LayoutNine>
  );
};

export default Collection;