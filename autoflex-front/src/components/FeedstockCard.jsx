import React, { useEffect } from "react";
import { useState } from "react";
import { requestData } from "../service";
import "../styles/FeedstockCard.css";

export default function FeedstockCard({ key, feedstock }) {
  const [productsOfFeedstock, setProductsOfFeedstock] = useState([]);
  const [products, setProducts] = useState([]);

  const addProductDependencies = async () => {
    const products = Promise.all(
      productsOfFeedstock.map(async (product) => {
        const productData = await requestData(`/product/${product[1]}`);
        return productData;
      })
    );

    setProducts(await products);
  };

  useEffect(() => {
    requestData(`/feedstock/${feedstock.id}/products`).then((data) =>
      setProductsOfFeedstock(data)
    );
  }, []);

  useEffect(() => {
    addProductDependencies();
  }, [productsOfFeedstock]);

  return (
    <div className="feedstock-card" key={key}>
      <h2 className="feedstock-card__title">Name: {feedstock.name}</h2>
      <p className="feedstock-card__description">
        Available Stock: {feedstock.quantity}
      </p>
      <p className="feedstock-card__description" >Producible products</p>
      <div className="products">
        {products.length !== 0 &&
          products.map((product, index) => (
            <div className="product-field" key={product.id}>
              <p className="product-field__id">{`Product ${index + 1}:`}</p>
              <h3>Name: {product.name}</h3>
              <p>Value: {product.value}</p>
            </div>
          ))}
      </div>
    </div>
  );
}
