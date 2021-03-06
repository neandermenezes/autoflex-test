import React from 'react'
import Header from '../components/Header'
import FeedstockTable from '../components/FeedstockTable'
import FeedstockForm from '../components/FeedstockForm'

export default function Feedstocks() {
  return (
    <>
      <Header />
      <section className="products-page">
        <FeedstockForm />
        <FeedstockTable />
      </section>
    </>
  )
}
