import React, { Component } from 'react'
import { InfoWindow } from '@react-google-maps/api'
import '../../src/css/default.css'
import Spaces from './Spaces';
import IChargerFilter from '../interface/IChargerFilter';

interface IMarkerWrappers {
  showingInfoWindow: boolean
  onMapClicked: Function
  markerWrapper: IChargerFilter
  markerMap: any
}

class InfoWindowContainer extends Component<IMarkerWrappers> {

  render() {

    const { markerWrapper, showingInfoWindow, onMapClicked, markerMap } = this.props

    return (<div>
      return {showingInfoWindow ?
        <InfoWindow anchor={markerMap[markerWrapper.charger.id]} onCloseClick={() => onMapClicked()}>
          <div>
            <b>Type:</b> {markerWrapper.charger.type}<br />
            <b>Description:</b> {markerWrapper.charger.description}<br />
            <Spaces totalSpaces={markerWrapper.charger.totalSpaces} usedSpaces={markerWrapper.charger.usedSpaces} />
          </div>
        </InfoWindow>
        : ''}
    </div>)
  }
}

export default InfoWindowContainer