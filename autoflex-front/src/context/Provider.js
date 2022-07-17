import React, { useEffect, useState } from 'react'
import PropTypes from 'prop-types'
import Context from './Context'
import { requestData } from '../service'

export default function Provider({ children }) {
  const [products, setProducts] = useState([])
  const [feedstocks, setFeedstocks] = useState([])

  useEffect(() => {
    requestData('/product')
      .then((data) => setProducts(data))
      .catch((e) => console.log(e))

      requestData('/feedstock')
      .then((data) => setFeedstocks(data))
      .catch((e) => console.log(e))
  }, [])

  const contextValue = {
    products,
    feedstocks
  }

  return (
    <Context.Provider value={ contextValue }>
      { children }
    </Context.Provider>
  )
}

Provider.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.node),
    PropTypes.node,
  ]).isRequired,
}