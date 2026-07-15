declare module '@apiverve/workingdays' {
  export interface workingdaysOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface workingdaysResponse {
    status: string;
    error: string | null;
    data: WorkingDaysData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface WorkingDaysData {
      workingDaysCount:    number | null;
      nonWorkingDaysCount: number | null;
      workingDays:         (Date | null)[];
      nonWorkingDays:      NonWorkingDay[];
  }
  
  interface NonWorkingDay {
      date:        Date | null;
      reasons:     (Reason | null)[];
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
