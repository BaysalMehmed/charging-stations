import React, { Component } from 'react'

interface ISpace {
    totalSpaces: number
    usedSpaces: number
}

class Spaces extends Component<ISpace> {

    drawSpaces(totalSpaces: number, usedSpaces: number): String[] {

        let spacesString = [];
        for (let i = 1; i <= totalSpaces; i++) {
            if (i <= usedSpaces) {
                spacesString.push("F")
            } else {
                spacesString.push("E")
            }
        }
        return spacesString;
    }

    getMarker(marker: String) {

        switch (marker) {
            case ("F"):
                return require('../icons/spaceMarkers/full.png')
            default:
                return require('../icons/spaceMarkers/empty.png')
        }
    }

    render() {

        const { totalSpaces, usedSpaces } = this.props;

        return (
            <div>
                <b>Spaces: </b> {this.drawSpaces(totalSpaces, usedSpaces).map((e, index) =>
                    <img key={index} src={this.getMarker(e)} alt={e.toString()} />)}
            </div>
        )
    }

}

export default Spaces