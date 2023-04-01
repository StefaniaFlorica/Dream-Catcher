import axios from 'axios'

const METRICS_API_BASE_URL = "http://localhost:8080/api/metricsService";
class SleepMetricsService {
  generateReport(frequencyType, recordType) {
    return axios.get(
      METRICS_API_BASE_URL + "/getReport/" + frequencyType + "/" + recordType
    );
  }
}
export default SleepMetricsService;