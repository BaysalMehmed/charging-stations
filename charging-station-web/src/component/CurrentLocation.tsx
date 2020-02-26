import React, { Component } from 'react'
import { Marker } from '@react-google-maps/api'
import '../../src/css/default.css'

interface ICurrentLocation {
    userLocation: any
}

class CurrentLocation extends Component<ICurrentLocation> {

    render() {

        const {userLocation } = this.props;

        return (
                <Marker position={userLocation} clickable={false}/>
        )
    }
}

export default CurrentLocation 