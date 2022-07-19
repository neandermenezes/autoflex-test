import React from "react";
import "../styles/Header.css";
import { useLocation, useNavigate } from "react-router-dom";

export default function Header() {
  const location = useLocation();
  const navigate = useNavigate();

  const navigationHelper = {
    "/": "feedstock",
    "/feedstock": "/",
    "/feedstock/products": "/",
  };

  return (
    <header className="header">
      <button className="header__btn" onClick={() => navigate(navigationHelper[location.pathname])}>
        {location.pathname === "/" ? "Go to Feedstocks" : "Go to Products"}
      </button>
      <h1>
      Autoflex Store
      </h1>
      { location.pathname !== "/feedstock/products" && (
        <button className="header__btn" onClick={() => navigate("/feedstock/products")}>
          Go to Feedstock Products
        </button>
      )}
    </header>
  );
}
