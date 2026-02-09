export default function DashBoard(){
    const cars=["bmw","audi", "RR"];
   return(
    <><h2> Dashboard</h2>
    <p>

</p>
<h2>{cars.map(car=><p>{car}</p>)}</h2> </>  )
}
