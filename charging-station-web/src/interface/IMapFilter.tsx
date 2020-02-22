import IChargerFilter from "./IChargerFilter";


interface IMapFilter{
    chargerFilters: IChargerFilter[]
    handleFilterToggle: Function
    }

    export default IMapFilter