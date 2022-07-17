import React, { useContext } from "react";
import Context from "../context/Context";
import { deleteData } from "../service";
import "../styles/ProductsTable.css";

export default function ProductsTable() {
  const { products } = useContext(Context);

  return (
    <table className="product-table">
      <thead>
        <tr className="product-table__row">
          <th>Id</th>
          <th>Name</th>
          <th>Value</th>
          <th>Delete</th>
          <th>Details</th>
        </tr>
      </thead>

      <tbody>
        {products &&
          products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>{product.value}</td>
              <td>
                <button
                  onClick={() => {
                    deleteData(product.id, "/product");
                    window.location.reload(false);
                  }}
                  className="product-table__btn"
                >
                  Delete
                </button>
              </td>
              <td>
                <button className="product-table__details">Details</button>
              </td>
            </tr>
          ))}
      </tbody>
    </table>
  );
}
