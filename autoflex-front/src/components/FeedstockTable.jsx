import React from "react";
import { useState, useContext } from "react";
import Context from "../context/Context";
import "../styles/ProductsTable.css";
import { deleteData, updateData } from "../service";

export default function FeedstockTable() {
  const [editingId, setEditingId] = useState(0);
  const [name, setName] = useState("");
  const [quantity, setQuantity] = useState("");

  const { feedstocks } = useContext(Context);

  const handleEdit = async () => {
    setEditingId(0);
    setName("");
    setQuantity("");

    await updateData(
      {
        name,
        quantity,
      },
      `/feedstock/${editingId}`
    );
    window.location.reload(false);
  };

  return (
    <table className="product-table">
      <thead>
        <tr className="product-table__row">
          <th>Id</th>
          <th>Name</th>
          <th>Quantity</th>
          <th>Delete</th>
          <th>Edit</th>
        </tr>
      </thead>

      <tbody>
        {feedstocks &&
          feedstocks.map((feedstock) =>
            editingId !== feedstock.id ? (
              <tr key={feedstock.id}>
                <td>{feedstock.id}</td>
                <td>{feedstock.name}</td>
                <td>{feedstock.quantity}</td>
                <td>
                  <button
                    onClick={() => {
                      deleteData(feedstock.id, "/feedstock");
                      window.location.reload(false);
                    }}
                    className="product-table__btn"
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    onClick={() => setEditingId(feedstock.id)}
                    className="product-table__details"
                  >
                    Edit
                  </button>
                </td>
              </tr>
            ) : (
              <tr key={feedstock.id}>
                <td>{feedstock.id}</td>
                <td>
                  <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    value={quantity}
                    onChange={(e) => setQuantity(e.target.value)}
                  />
                </td>
                <td>
                  <button
                    onClick={() => handleEdit()}
                    className="product-table__btn"
                    disabled={name === "" || quantity === ""}
                  >
                    Edit
                  </button>
                </td>
                <td>
                  <button
                    className="product-table__details"
                    type="button"
                    onClick={() => {
                      setEditingId(0);
                      setName("");
                      setQuantity("");
                    }}
                  >
                    cancelEdit
                  </button>
                </td>
              </tr>
            )
          )}
      </tbody>
    </table>
  );
}
