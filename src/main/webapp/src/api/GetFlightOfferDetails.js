import axiosInstance from "./axiosInstance"

const GetFlightOfferDetails = (flightOfferId) => {
    return new Promise((resolve, reject) => {
        axiosInstance.get('/flight-offer-details', {
            params: {
                id: flightOfferId
            }}).then(response => {
            let details = response.data.flightOfferDetails;
            resolve(details)
        }).catch(error => { 
            reject(error)
        })
    });
};

export default GetFlightOfferDetails