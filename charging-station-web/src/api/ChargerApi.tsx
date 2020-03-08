
class ChargerApi{

  static async getMarkers(): Promise<any> {
    
    return fetch('http://localhost:8080/chargers', { headers: { 'Access-Control-Allow-Origin': '*' } })
              .then(res => res.json())
              .then((data) => {
                console.log(data);
              })
  }
}

export default ChargerApi

