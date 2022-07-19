import React, { useState } from "react";
import { createData } from "../service";
import "../styles/ProductForm.css";

export default function FeedstockForm() {
  const [name, setName] = useState("");
  const [quantity, setQuantity] = useState("");
  const [isCreating, setIsCreating] = useState(false);

  const handleCreateData = async () => {
    setIsCreating(false);

    const data = {
      name,
      quantity,
    };

    await createData(data, "/feedstock");

    setIsCreating(false);
    setName("");
    setQuantity("");

    window.location.reload(false);
  };

  return isCreating ? (
    <div className="product-form">
      <h2 className="product-form__title">Create Feedstock</h2>
      <label className="product-form__label" htmlFor="name">
        Name
      </label>
      <input
        className="product-form__input"
        type="text"
        id="name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <label className="product-form__label" htmlFor="quantity">
        Quantity
      </label>
      <input
        className="product-form__input"
        type="text"
        id="quantity"
        value={quantity}
        onChange={(e) => setQuantity(e.target.value)}
      />

      <div className="btns">
        <button
          className="product-form__btn"
          disabled={name === "" || quantity === ""}
          onClick={handleCreateData}
        >
          Create
        </button>
        <button
          className="product-form__btn"
          onClick={() => setIsCreating(false)}
        >
          Cancel
        </button>
      </div>
    </div>
  ) : (
    <button
      className="product-form__btn--create"
      onClick={() => setIsCreating(true)}
    >
      Create Feedstock
    </button>
  );
}
