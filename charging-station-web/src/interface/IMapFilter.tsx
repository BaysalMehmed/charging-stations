import IChargerTypeFilter from "./IChargerTypeFilter";


interface IMapFilter{
    chargerFilters: IChargerTypeFilter[]
    handleFilterToggle: Function
    }

    export default IMapFilter