import React, { useEffect, useState } from "react";
import PropTypes from "prop-types";
import Context from "./Context";
import { requestData } from "../service";

export default function Provider({ children }) {
  const [products, setProducts] = useState([]);
  const [feedstocks, setFeedstocks] = useState([]);
  const [feedstockProductsArray, setFeedstockProductsArray] = useState([]);

  useEffect(() => {
    requestData("/product")
      .then((data) => setProducts(data))
      .catch((e) => console.log(e));

    requestData("/feedstock")
      .then((data) => setFeedstocks(data))
      .catch((e) => console.log(e));

    requestData("/feedstock/products")
      .then((data) => setFeedstockProductsArray(data))
      .catch((e) => console.log(e));
  }, []);

  const contextValue = {
    products,
    feedstocks,
    feedstockProductsArray
  };

  return <Context.Provider value={contextValue}>{children}</Context.Provider>;
}

Provider.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.node),
    PropTypes.node,
  ]).isRequired,
};
