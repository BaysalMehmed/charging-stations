import React, { Component } from 'react'
import { Grid, Paper} from '@material-ui/core'
import IChargerFilter from '../interface/IChargerFilter'

interface IChargerListProps {
    markersToRender: IChargerFilter[]
    onChargerListItemClick: Function
}

class ChargerList extends Component<IChargerListProps> {

    render() {

        const { markersToRender, onChargerListItemClick } = this.props
        return (
            <div>
                    <Grid className="overlay" container justify="flex-end">
                    <Grid className="test" item  >
                    <Grid item xs={12} >
                        {
                            markersToRender.filter(e => e.show).map(e => {
                                return <Grid key={"grid" + e.charger.id} item  >
                                    <Paper id="chargerListItem" key={"paper" + e.charger.id} style={{ cursor: 'pointer' }}
                                        onClick={() => onChargerListItemClick(e)}>{e.charger.type} - {e.charger.description}</Paper>
                                </Grid>
                            })
                        }
                    </Grid >
                    </Grid></Grid>
            </div>
        )
    }
}

export default ChargerList