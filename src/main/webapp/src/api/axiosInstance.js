import axios from 'axios'

const axiosInstance = axios.create({
    baseURL: "http://localhost:8443/api",
    headers: {
        'contentType': 'application/json',
        'Accept': 'application/json',
        "Cache-Control": "no-cache",
        "access-Control-Allow-Origin": "*"
    }
}) 

export default axiosInstance

