import React, { useContext, useEffect } from "react";
import Context from "../context/Context";
import Header from "../components/Header";
import FeedstockCard from "../components/FeedstockCard";

export default function FeedstockProducts() {
  const { feedstocks } = useContext(Context);

  return (
    <>
      <Header />
      <section className="feedstock-container">
        {feedstocks.map((feedstock) => (
          <FeedstockCard key={feedstock.id} feedstock={feedstock} />
        ))}
      </section>
    </>
  );
}
