import IMarkerWrapper from '../interface/IMarkerWrapper';


class ChargerApi{

  static getMarkers(): IMarkerWrapper[] {
    return [
      { id: 1, marker: { lat: 51.610905, lng: -0.540674 }, description: "First", type: "Tesla SuperCharger", totalSpaces: 10, usedSpaces: 2 },
      { id: 2, marker: { lat: 51.613821, lng: -0.560712 }, description: "Fourth", type: "Tesla SuperCharger", totalSpaces: 8, usedSpaces: 2 },
      { id: 3, marker: { lat: 51.600438, lng: -0.551322 }, description: "Second", type: "CCS", totalSpaces: 4, usedSpaces: 1 },
      { id: 4, marker: { lat: 51.599167, lng: -0.560252 }, description: "Third", type: "Type 2", totalSpaces: 1, usedSpaces: 0 }
    ]
  }

  static getChargerTypes(){
    return [
    {id: 1, type: "Tesla SuperCharger"},
    {id: 2, type: "CCS"},
    {id: 3, type: "Type 2"},
    ]
  }
}

export default ChargerApi

