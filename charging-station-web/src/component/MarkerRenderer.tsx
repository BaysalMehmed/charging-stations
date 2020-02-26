import React, { Component } from 'react'
import { Marker } from '@react-google-maps/api'
import '../../src/css/default.css'
import IChargerFilter from '../interface/IChargerFilter';

interface IMarkerRender {
    markersToRender: IChargerFilter[]
    onMarkerClick: Function
    onMarkerLoad: Function
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

        const { markersToRender, onMarkerClick, onMarkerLoad } = this.props;

        return (
            <div>
                {markersToRender.map((e, index) => {
                    return <Marker visible={e.show} key={index} position={e.charger.marker} clickable={true}
                        onClick={() => onMarkerClick(e.charger)} onLoad={(marker => onMarkerLoad(marker, e.charger.id))} 
                        icon={this.getMarker(e.charger.type)} 
                        />
                })}

            </div>
        )
    }
}

export default MarkerRenderer