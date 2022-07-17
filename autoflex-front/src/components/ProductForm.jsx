import React, { useContext, useEffect, useState } from "react";
import "../styles/ProductForm.css";
import Context from "../context/Context";
import FeedstockTable from "./FeedstockTable";

export default function ProductForm() {
  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const [feedstocksToAdd, setFeedstocksToAdd] = useState([]);
  const [isCreating, setIsCreating] = useState(false);
  const [availableFeedstocks, setAvailableFeedstocks] = useState([]);

  const { feedstocks } = useContext(Context);

  useEffect(() => {
    setAvailableFeedstocks(feedstocks);
  })

  return (
    isCreating ? (
      <div className="product-form">
        <h2>Create Product</h2>
        <label htmlFor="name">Name</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <label htmlFor="value">Value</label>
        <input
          type="text"
          id="value"
          value={value}
          onChange={(e) => setValue(e.target.value)}
        />
        <button
          onClick={() => {
            setIsCreating(false);
            setName("");
            setValue("");
          }}
        >
          Cancel
        </button>
        <button
          onClick={() => {
            setIsCreating(false);
            setName("");
            setValue("");
          }}
        >
          Create
        </button>
        <div className="product-form__feedstock">
          <h3>Feedstocks</h3>
          { availableFeedstocks && availableFeedstocks.map((feedstock) => (
            <div key={feedstock.id}>
              <p>{feedstock.id}</p>
              <p>{feedstock.name}</p>
              <p>{feedstock.quantity}</p>
              <button
                onClick={() => {
                  setFeedstocksToAdd([...feedstocksToAdd, feedstock]);
                  setAvailableFeedstocks((feedstock.id) => )
                }
                }
              >
                Add
              </button>
            </div>
          ))}
        </div>
      </div>
    ) : (
      <button onClick={ () => setIsCreating(true) } className="product-form__btn--create">Create Product</button>
    )
  );
}
