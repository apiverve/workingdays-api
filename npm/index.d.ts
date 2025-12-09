declare module '@apiverve/workingdays' {
  export interface workingdaysOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface workingdaysResponse {
    status: string;
    error: string | null;
    data: WorkingDaysData;
    code?: number;
  }


  interface WorkingDaysData {
      workingDaysCount:    number;
      nonWorkingDaysCount: number;
      workingDays:         Date[];
      nonWorkingDays:      NonWorkingDay[];
  }
  
  interface NonWorkingDay {
      date:        Date;
      reasons:     Reason[];
      holidayName: null | string;
  }
  
  enum Reason {
      PublicHoliday = "public holiday",
      Weekend = "weekend",
  }

  export default class workingdaysWrapper {
    constructor(options: workingdaysOptions);

    execute(callback: (error: any, data: workingdaysResponse | null) => void): Promise<workingdaysResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: workingdaysResponse | null) => void): Promise<workingdaysResponse>;
    execute(query?: Record<string, any>): Promise<workingdaysResponse>;
  }
}
