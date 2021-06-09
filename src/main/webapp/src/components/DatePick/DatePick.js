import React from 'react';
import DatePicker, { registerLocale }  from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import "./DatePick.css"
import hr from 'date-fns/locale/hr';
registerLocale('hr', hr)


const DatePick = (props) => {
    
    return (
        <DatePicker 
            isClearable={props.isClearable}
            dateFormat="dd.MM.yyyy" 
            locale="hr" 
            selected={props.value} 
            onChange={(date)=>props.handleDateChange(date, props.name)}
            minDate={props.minDate}
        />
    );
}

export default DatePick;