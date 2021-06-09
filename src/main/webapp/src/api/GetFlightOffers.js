
import axiosInstance from "./axiosInstance"

const GetFlightOffers = (searchForm, tableForm) => {
    return new Promise((resolve, reject) => {
        axiosInstance.post('/flight-offers', 
            { 
                searchForm: searchForm,
                tableForm: tableForm
            }).then(response => {

            let flights = response.data.flightList;
            let pages = response.data.pages
            const res = {
                rows: flights,
                pages: pages
            };
            resolve(res)
        }).catch(error => {
            reject(error)
        })
    });
};

export default GetFlightOffers
