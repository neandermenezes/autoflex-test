import axios from "axios";

const api = axios.create({
  baseURL: `http://localhost:${process.env.REACT_APP_API_PORT || '8080'}`,
  timeout: 1000,
});

export const requestData = async (endpoint) => {
  const { data } = await api.get(endpoint);
  return data;
}

export const deleteData = async (id, endpoint) => {
  await api.delete(`${endpoint}/${id}`);
}

export const createData = async (body, endpoint) => {
  const { data } = await api.post(endpoint, body)
  return data
}

export const updateData = async (body, endpoint) => {
  await api.put(endpoint, body)
}