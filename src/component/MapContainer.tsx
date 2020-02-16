import React, { Component } from 'react'
import { GoogleMap, LoadScript } from '@react-google-maps/api'
import '../../src/css/default.css'
import InfoWindowContainer from './InfoWindowContainer';
import IMarkerWrapper from '../interface/IMarkerWrapper';
import MarkerRenderer from './MarkerRenderer';
import ChargerApi from '../api/ChargerApi'
import IChargerFilter from '../interface/IChargerFilter';
import MapFilter from './MapFilter';
import ChargerList from './ChargerList';

class MapContainer extends Component {

  constructor(props) {
    super(props)
    this.handleToggle = this.handleToggle.bind(this)
    this.onMarkerClick = this.onMarkerClick.bind(this)
    this.onMapClicked = this.onMapClicked.bind(this)
    this.onChargerListItemClick = this.onChargerListItemClick.bind(this)
  }

  state = {
    showingInfoWindow: false,
    markerWrapper: null,
    filterOptions: { filterChargers: this.getChargerTypesForFilter() },
    userLocation: null
  };

  componentDidMount() {
    navigator.geolocation.getCurrentPosition(
      position => {
        const { latitude, longitude } = position.coords;

        this.setState({
          userLocation: { lat: latitude, lng: longitude }
        });
      }
    );
  }

  onMarkerClick(markerWrapper: IMarkerWrapper) {
    return this.setState({
      showingInfoWindow: true,
      markerWrapper: markerWrapper
    });
  };

  onMapClicked() {
    if (this.state.showingInfoWindow) {
      this.setState({
        showingInfoWindow: false,
        markerWrapper: null
      })
    }
  };

  handleToggle(chargerType: String) {

    var { filterOptions } = this.state

    var chargerTypeIndex = filterOptions.filterChargers.findIndex(e => e.type === chargerType)

    const newFilterChargers = filterOptions.filterChargers.slice()
    newFilterChargers[chargerTypeIndex].showType = !filterOptions.filterChargers[chargerTypeIndex].showType

    this.setState({
      filterOptions: { filterChargers: newFilterChargers }
    })

  }

  onChargerListItemClick(markerWrapper: IMarkerWrapper){
    return this.setState({
      showingInfoWindow: true,
      markerWrapper: markerWrapper
    });
  }

  getChargerTypesForFilter(): IChargerFilter[] {
    return ChargerApi.getChargerTypes().map((e) => {
      return { type: e.type, showType: true }
    })
  }

  filterChargersToRender(allChargers: IMarkerWrapper[], filters: IChargerFilter[]): IMarkerWrapper[] {
    return allChargers.filter(e => filters.map(f => f.showType === true && f.type).includes(e.type))
  }

  render() {

    const { filterOptions, markerWrapper, showingInfoWindow, userLocation } = this.state
    const markersToRender = this.filterChargersToRender(ChargerApi.getMarkers(), filterOptions.filterChargers)

    return (

      <LoadScript id="script-loader" googleMapsApiKey="AIzaSyDfGvw5rt-MyoRRKcNgs0HaNumY7uDDvyk" >

        <GoogleMap
          id='map'
          zoom={14}
          center={userLocation != null ? userLocation : ChargerApi.getMarkers()[0].marker}
          onClick={this.onMapClicked}>

          <MarkerRenderer markersToRender={markersToRender} onMarkerClick={this.onMarkerClick} ></MarkerRenderer>

          <InfoWindowContainer
            markerWrapper={markerWrapper}
            onMapClicked={this.onMapClicked}
            showingInfoWindow={showingInfoWindow} />

        </GoogleMap>
        <MapFilter chargerFilters={filterOptions.filterChargers} handleFilterToggle={this.handleToggle} />

        <ChargerList markersToRender={markersToRender} onChargerListItemClick={this.onChargerListItemClick} />
      </LoadScript>


    )
  }
}

export default MapContainer