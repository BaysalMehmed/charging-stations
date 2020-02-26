import React, { Component } from 'react'
import { InfoWindow } from '@react-google-maps/api'
import '../../src/css/default.css'
import Spaces from './Spaces';
import IMarkerWrapper from '../interface/IMarkerWrapper';

interface IMarkerWrappers{
    showingInfoWindow: boolean
    onMapClicked: Function
    markerWrapper: IMarkerWrapper
    markerMap: any
}

class InfoWindowContainer extends Component<IMarkerWrappers> {

  render() {

    const {markerWrapper, showingInfoWindow, onMapClicked, markerMap} = this.props

    return (<div>
          {showingInfoWindow ?
            <InfoWindow 
            //position={{ lat: markerWrapper.marker.lat + 0.002, lng: markerWrapper.marker.lng }}
            anchor={markerMap[markerWrapper.id]}
              onCloseClick={() => onMapClicked()}
              >
              <div>
                <b>Type:</b> {markerWrapper.type}<br />
                <b>Description:</b> {markerWrapper.description}<br />
                <Spaces totalSpaces={markerWrapper.totalSpaces} usedSpaces={markerWrapper.usedSpaces}/>
              </div>
            </InfoWindow>
            : ''}
    </div>)
  }
}

export default InfoWindowContainer