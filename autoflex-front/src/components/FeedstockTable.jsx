import React from "react";
import { useContext } from "react";
import Context from "../context/Context";
import "../styles/ProductsTable.css";
import { deleteData } from "../service";

export default function FeedstockTable() {
  const { feedstocks } = useContext(Context);

  return (
    <table className="product-table">
      <thead>
        <tr className="product-table__row">
          <th>Id</th>
          <th>Name</th>
          <th>Quantity</th>
          <th>Delete</th>
          <th>Details</th>
        </tr>
      </thead>

      <tbody>
        {feedstocks &&
          feedstocks.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>{product.value}</td>
              <td>
                <button
                  onClick={() => {
                    deleteData(product.id, "/feedstock");
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
