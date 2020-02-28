import React, { Component } from 'react'
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api'
import '../../src/css/default.css'
import InfoWindowContainer from './InfoWindowContainer';
import MarkerRenderer from './MarkerRenderer';
import ChargerApi from '../api/ChargerApi'
import IChargerTypeFilter from '../interface/IChargerTypeFilter';
import MapFilter from './MapFilter';
import ChargerList from './ChargerList';
import UserLocation from './CurrentLocation'
import IChargerFilter from '../interface/IChargerFilter';

interface IMapContainer {
  showingInfoWindow: boolean,
  markerWrapper: IChargerFilter,
  filterOptions: { filterChargers: IChargerTypeFilter[] },
  userLocation: { lat: number, lng: number },
  markerMap: any
}

class MapContainer extends Component<null, IMapContainer> {

  constructor(props) {
    super(props)
    this.handleToggle = this.handleToggle.bind(this)
    this.onMarkerClick = this.onMarkerClick.bind(this)
    this.onMarkerLoad = this.onMarkerLoad.bind(this)
    this.onMapClicked = this.onMapClicked.bind(this)
  }

  state = {
    showingInfoWindow: false,
    markerWrapper: null,
    filterOptions: { filterChargers: this.getChargerTypesForFilter() },
    userLocation: null,
    markerMap: {}
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

  onMarkerClick(markerWrapper: IChargerFilter) {
      this.setState({ showingInfoWindow: false }, () => {
        setTimeout(() => {
          this.setState({ showingInfoWindow: true,
               markerWrapper: markerWrapper });
        }, 10);
      })

  };

  onMarkerLoad(marker: Marker, markerId: number) {
    return this.setState(prevState => ({
      markerMap: { ...prevState.markerMap, [markerId]: marker }
      }));
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

    var { filterOptions, markerWrapper} = this.state

    var chargerTypeIndex = filterOptions.filterChargers.findIndex(e => e.type === chargerType)

    const newFilterChargers = filterOptions.filterChargers.slice()
    newFilterChargers[chargerTypeIndex].showType = !filterOptions.filterChargers[chargerTypeIndex].showType

    const resetFocus = markerWrapper != null ? (markerWrapper.type === chargerType ? false : true) : false

    this.setState(prevState => ({
      showingInfoWindow: resetFocus,
      markerWrapper: resetFocus ? prevState.markerWrapper : null,
      filterOptions: { filterChargers: newFilterChargers }
    }))

  }

  getChargersForFilter(): IChargerFilter[]{

    return ChargerApi.getMarkers().map((e) => {
      return {charger: e, show: true}
    })
  }

  getChargerTypesForFilter(): IChargerTypeFilter[] {
    return ChargerApi.getChargerTypes().map((e) => {
      return {id: e.id, type: e.type, showType: true }
    })
  }

  filterChargersToRender(allChargers: IChargerFilter[], filters: IChargerTypeFilter[]): IChargerFilter[] {

    allChargers.forEach((charger, index) => {
      allChargers[index].show = filters.filter(e => e.showType === true).flatMap(e => e.type).includes(charger.charger.type) ? true : false
    })
    return allChargers;
  }

  render() {

    const { filterOptions, markerWrapper, showingInfoWindow, markerMap, userLocation } = this.state
    const markersToRender = this.filterChargersToRender(this.getChargersForFilter(), filterOptions.filterChargers)

    return (

      <LoadScript id="script-loader" googleMapsApiKey="API" >

        <GoogleMap
          id='map'
          zoom={14}
          center={userLocation != null ? userLocation : ChargerApi.getMarkers()[0].marker}
          onClick={this.onMapClicked} options={{streetViewControl: false}} >

          <UserLocation userLocation={userLocation}/>

          <MarkerRenderer markersToRender={markersToRender} onMarkerClick={this.onMarkerClick} onMarkerLoad={this.onMarkerLoad} />

          <InfoWindowContainer
            markerMap={markerMap}
            markerWrapper={markerWrapper}
            onMapClicked={this.onMapClicked}
            showingInfoWindow={showingInfoWindow} />

        </GoogleMap>
        <MapFilter chargerFilters={filterOptions.filterChargers} handleFilterToggle={this.handleToggle} />

        <ChargerList markersToRender={markersToRender} onChargerListItemClick={this.onMarkerClick} />
      </LoadScript>


    )
  }
}

export default MapContainer
