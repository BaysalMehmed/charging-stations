import React, { Component } from 'react'
import { Marker } from '@react-google-maps/api'
import '../../src/css/default.css'
import IMarkerWrapper from '../interface/IMarkerWrapper';

interface IMarkerRender {
    markersToRender: IMarkerWrapper[]
    onMarkerClick: Function
}

class MarkerRenderer extends Component<IMarkerRender> {

    getMarker(chargerType: String) {
        switch (chargerType) {
            case ("Tesla SuperCharger"):
                return require('../icons/chargeTypes/tesla.png')
            default:
                break
        }
    }

    render() {

        const { markersToRender, onMarkerClick } = this.props;

        return (
            <div>
                {markersToRender.map((e, index) => {
                    return <Marker key={index} position={e.marker} clickable={true}
                        onClick={() => onMarkerClick(e)} icon={this.getMarker(e.type)} />
                })}

            </div>
        )
    }
}

export default MarkerRenderer