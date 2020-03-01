import React, { Component } from 'react'
import { Marker } from '@react-google-maps/api'
import '../../src/css/default.css'
import ICurrentLocation from '../interface/ICurrentLocation';

class CurrentLocation extends Component<ICurrentLocation> {

    render() {
        const {userLocation} = this.props;

        const icon = {
            url: require('../icons/location/currentLocation.png'),
            scaledSize: new google.maps.Size(50, 50)
        }
        return (<Marker position={userLocation} icon={icon} />)
    }
}

export default CurrentLocation 