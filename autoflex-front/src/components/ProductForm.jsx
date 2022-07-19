import React, { useContext, useEffect, useState } from "react";
import "../styles/ProductForm.css";
import Context from "../context/Context";
import FeedstockTable from "./FeedstockTable";
import { createData } from "../service";

export default function ProductForm() {
  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const [feedstocksToAdd, setFeedstocksToAdd] = useState([]);
  const [isCreating, setIsCreating] = useState(false);
  const [availableFeedstocks, setAvailableFeedstocks] = useState([]);

  const { feedstocks } = useContext(Context);

  useEffect(() => {
    setAvailableFeedstocks(feedstocks);
  });

  const handleAddFeedstock = (feedstock, isChecked) => {
    if (!isChecked) {
      setFeedstocksToAdd(feedstocksToAdd.filter((f) => f.id !== feedstock.id));
    } else {
      setFeedstocksToAdd([...feedstocksToAdd, feedstock]);
    }
    console.log(feedstock, isChecked);
  };

  const handleCreateData = async () => {
    setIsCreating(false);

    const data = {
      name,
      value,
      feedstockIds: feedstocksToAdd.map((f) => f.id),
    };

    await createData(data, "/product");

    setIsCreating(false);
    setName("");
    setValue("");
    setFeedstocksToAdd([]);

    window.location.reload(false);
  };

  return isCreating ? (
    <div className="product-form">
      <h2 className="product-form__title">Create Product</h2>
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
      <label className="product-form__label" htmlFor="value">
        Value
      </label>
      <input
        className="product-form__input"
        type="text"
        id="value"
        value={value}
        onChange={(e) => setValue(e.target.value)}
      />

      <div className="btns">
        <button
          className="product-form__btn"
          onClick={() => {
            setIsCreating(false);
            setName("");
            setValue("");
            setFeedstocksToAdd([]);
          }}
        >
          Cancel
        </button>
        <button
          className="product-form__btn"
          disabled={!name || !value || !feedstocksToAdd.length}
          onClick={() => {
            setIsCreating(false);
            setName("");
            setValue("");
            handleCreateData();
          }}
        >
          Create
        </button>
      </div>

      <div className="product-form__feedstock">
        <h3 className="product-form__title">
          Necessary feedstocks to produce:{" "}
        </h3>
        {availableFeedstocks &&
          availableFeedstocks.map((feedstock) => (
            <div className="feedstock" key={feedstock.id}>
              <input
                onClick={({ target }) =>
                  handleAddFeedstock(feedstock, target.checked)
                }
                type="checkbox"
              />
              <p className="feedstock__name">{feedstock.name}</p>
            </div>
          ))}
      </div>
    </div>
  ) : (
    <button
      onClick={() => setIsCreating(true)}
      className="product-form__btn--create"
    >
      Create Product
    </button>
  );
}
