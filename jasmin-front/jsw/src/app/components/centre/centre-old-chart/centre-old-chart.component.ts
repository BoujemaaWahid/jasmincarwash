import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'centre-old-chart',
  templateUrl: './centre-old-chart.component.html',
  styleUrls: ['./centre-old-chart.component.scss']
})
export class CentreOldChartComponent implements OnInit {
  chartOptions: any = {
    series: [
      {
        name: "My-series",
        data: [10, 0, 35, 51, 49, 62, 69, 91, 148]
      },
      {
        name: "My-series",
        data: [11, 51, 0, 91, 19, 42, 79, 10, 48]
      }
    ],
    chart: {
      height: 300,
      type: "area",
      stacked:true,
      animations:{
        enabled: true
      }
    },
    title: {
      text: "Semaine derniére"
    },
    xaxis: {
      categories: ["Jan", "Feb",  "Mar",  "Apr",  "May",  "Jun",  "Jul",  "Aug", "Sep"]
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
