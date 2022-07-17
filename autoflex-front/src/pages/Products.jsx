import React from "react";
import Header from "../components/Header";
import ProductsTable from "../components/ProductsTable";
import ProductForm from "../components/ProductForm";

export default function Products() {
  return (
    <>
      <Header />
      <section className="products-page">
        <ProductForm />
        <ProductsTable />
      </section>
    </>
  );
}
