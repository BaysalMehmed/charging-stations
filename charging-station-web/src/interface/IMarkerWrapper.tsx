import IMarker from "./IMarker";

interface IMarkerWrapper {
  id: number
  location: IMarker
  description: String
  type: String
  totalSpaces: number
  usedSpaces: number
}

export default IMarkerWrapper