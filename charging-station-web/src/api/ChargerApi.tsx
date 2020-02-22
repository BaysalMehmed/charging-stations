import IMarkerWrapper from '../interface/IMarkerWrapper';


class ChargerApi{

  static getMarkers(): IMarkerWrapper[] {
    return [
      { marker: { lat: 51.610905, lng: -0.550674 }, description: "First", type: "Tesla SuperCharger", totalSpaces: 10, usedSpaces: 2 },
      { marker: { lat: 51.613821, lng: -0.560712 }, description: "Fourth", type: "Tesla SuperCharger", totalSpaces: 8, usedSpaces: 2 },
      { marker: { lat: 51.600438, lng: -0.551322 }, description: "Second", type: "CCS", totalSpaces: 4, usedSpaces: 1 },
      { marker: { lat: 51.599167, lng: -0.560252 }, description: "Third", type: "Type 2", totalSpaces: 1, usedSpaces: 0 }
    ]
  }

  static getChargerTypes(){
    return [
    {type: "Tesla SuperCharger"},
    {type: "CCS"},
    {type: "Type 2"},
    ]
  }
}

export default ChargerApi

