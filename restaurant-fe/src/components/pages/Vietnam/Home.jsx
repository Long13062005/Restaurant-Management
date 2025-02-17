import {NavBar} from "./Home/NavBar.jsx";
import {HeroSection} from "./Home/HeroSection.jsx";
import React from "react";
import {ReservationSection} from "./Home/ReservationSection.jsx";
import {ContractSection} from "./Home/ContractSection.jsx";
import {Footer} from "./Home/Footer.jsx";
import {MenuSection} from "./Home/MenuSection.jsx";

export function Home() {
  return (
    <div className="background">
      <NavBar />
      <HeroSection />
      <MenuSection />
      <ReservationSection />
      <ContractSection />
      <Footer />
    </div>
  );
}