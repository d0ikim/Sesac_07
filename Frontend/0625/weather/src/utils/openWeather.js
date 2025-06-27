
import OpenWeather from "openweathermap-ts";

const openWeather = new OpenWeather({
  apiKey: "84f256e94bb1ecda8c1f1eab6dd04ef3"
})

openWeather.setUnits("metric")

export default openWeather; 